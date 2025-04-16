package ui.custom.screen;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainScreen {
    private final static Dimension dimension = new Dimension(width: 600, height:600);

    private final BoardService boarService;

    private JButton checkGameStatusButton;
    private JButton finishGameButton;
    private JButton resetButton;

    public MainScreen(final Map<String, String> gameConfig){
        this.boardService = new BoardService(gameConfig);
    }

    public void buildMainScreen(){
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        addResetButton(mainPanel);
        addCheckGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void addResetButton(final JPanel mainPanel){
        resetButton = new ResetButton(e ->{
            var dialogResult: int = JOptionPane.showConfirmDialog(
                parentComponent: null,
                message: "Deseja realmente reiniciar o jogo?",
                title: "Limpar o jogo",
                YES_NO_OPTION,
                QUESTION_MESSAGE
            );
            if(dialogResult == 0){
                boardService.reset();
            }
        });
        mainPanel.add(resetButton)
    }

    private void addCheckGameStatusButton(final JPanel mainPanel){
        JcheckGameStatusButton = new FinishGameButton(e ->{
            var hasErrors: boolean boardService.hasErros();
            var gameStatus: GameStatusEnum = boardService.getStatus();
            var message: String = switch (gameStatus){
                case NON_STARTED -> "O jogo não foi iniciado";
                case INCOMPLETE -> "O jogo está incompleto";
                case COMPLETE -> "O jogo está completo";
            };
            message += hasErros ? "e contém erros " : " e não contém erros ";
            JOptionPane.showMessageDialogo(parentComponent null, message);
        });
        mainPanel.add(checkGameStatusButton);
    }

    private void addFinishGameButton JPanel mainPanel){
        finishGameButton = new FinishGameButton(e -> {
            if(boardService.gameFinished()){
                JOptionPane.showMessageDialog(parentComponent: null, message: "Parabéns você conclui o jogo");
                resetButton(false);
                checkGameStatusButton(false);
                finishGameButton(false);
            }
            else{
                JOptionPane.showMessageDialog(parentComponent: null, message: "Seu jogo tem alguma inconscistencia, ajuste e tente novamente");
            }
        });

        mainPanel.add(finishGameButton);
    }
}
