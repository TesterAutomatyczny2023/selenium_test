package playground;

public class MethodChaining {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("to ");
        stringBuilder.append("nie ");
        stringBuilder.append("jest ");
        stringBuilder.append("łączenie ");
        stringBuilder.append("metod. ");

        stringBuilder.append("A ").append("to ").append("tak!");
        System.out.println(stringBuilder);

        Chain chain = new Chain();
        chain.add("To ")
                .add("jest ")
                .add("łączenie ")
                .add("metod.");
        System.out.println(chain);
    }
}
