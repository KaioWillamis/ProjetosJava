package ui.custom.screen;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import service.NotifierService;

public class MainScreen {
    private final static Dimension dimension = new Dimension(width: 600, height:600);

    private final BoardService boarService;
    private final NotifierService notifierService;

    private JButton checkGameStatusButton;
    private JButton finishGameButton;
    private JButton resetButton;

    public MainScreen(final Map<String, String> gameConfig){
        this.boardService = new BoardService(gameConfig);
        this.notifierService = new NotifierService();
    }

    public void buildMainScreen(){
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        for(int r = 0; r < 9; r+=3){
            var endRow = r + 2;
            for(int c = 0; c < 9; c+=3){
                var endCol = c + 2;
                var spaces = getSpacesFromSector(boardService.getSpaces(), c, endCol, r, endRow);
                JPanel sector = generateSection(spaces);
                mainPanel.add(sector)
            }
        }
        addResetButton(mainPanel);
        addCheckGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private List<Space> getSpacesFromSector(final List<List<Space> spaces, final int iniColl, final int endCol, final int initRow, final int endRow){
        List<Space> spaceSector = new ArrayList<>();
        for(int r = initRow; r <= endRow; r++){
            for(int c = initCol; c <= endCol; c++){
                spaceSector.add(spaces.get(c).get(r));
            }
        }
        return spaceSector;
    }

    private JPanel generateSection(final List<Space> spaces){
        List<NumberText> fields = new ArrayList<>(spaces.stream().map(NumberText::new).toList());
        fields.forEach(t -> notifierService.subscribe(CLEAR_SPACE, t));
        return new SudokuSector(fields);
    }

    private void addResetButton(final JPanel mainPanel){
        resetButton = new ResetButton(e ->{
            var dialogResult: int = showConfirmDialog(
                parentComponent: null,
                message: "Deseja realmente reiniciar o jogo?",
                title: "Limpar o jogo",
                YES_NO_OPTION,
                QUESTION_MESSAGE
            );
            if(dialogResult == 0){
                boardService.reset();
                notifierService.notify(CLEAR_SPACE)
            }
        });
        mainPanel.add(resetButton)
    }

    private void addCheckGameStatusButton(final JPanel mainPanel){
        JcheckGameStatusButton = new checkGameStatusButton(e ->{
            var hasErrors: boolean boardService.hasErros();
            var gameStatus: GameStatusEnum = boardService.getStatus();
            var message: String = switch (gameStatus){
                case NON_STARTED -> "O jogo não foi iniciado";
                case INCOMPLETE -> "O jogo está incompleto";
                case COMPLETE -> "O jogo está completo";
            };
            message += hasErros ? "e contém erros " : " e não contém erros ";
            showMessageDialogo(parentComponent null, message);
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
