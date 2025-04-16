package model;

public enum GameStatusEnum {
    NON_STARTED(label: "não iniciado"),
    IMCOMPLETE(label: "incompleto"),
    COMPLETE(label: "completo");

    private String label;

    GameStatusEnum(final String label){
        this.label = label;
    }
}
