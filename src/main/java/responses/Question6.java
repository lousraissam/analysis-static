package responses;

import visitors.ClassVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class Question6 {

    public ClassVisitor classVisitor = new ClassVisitor();
    public int totalMethodsNbr = 0;
    public int totalMethodsLine = 0;

    public double getMethodMoyLines(){
        Question3_5_7 question3_5_7 = new Question3_5_7();
        totalMethodsNbr = question3_5_7.getTotalMethodsNbr();
        for (var entry : classVisitor.getMethods().entrySet()) {
            for (MethodDeclaration method : entry.getValue()) {
                //System.out.println(method.getName().toString());
                //System.out.println(method.getBody().toString());
                //System.out.println(method.getBody().toString().split("\n").length);
                //System.out.println("-----------------\n");
                totalMethodsLine += method.getBody().toString().split("\n").length;
            }
        }

        System.out.println("Explanation for how calculation on lines it goes on : \n" +
                "* We have :\n" +
                "  public static void main(String[] args) {\n" +
                "     Object object = new Object();\n" +
                "     \n" +
                "     object.KillAll();\n" +
                "     //help me!!\n" +
                "     System.out.println(\"good bay\");\n" +
                "  }\n" +
                "\n" +
                "* The body is :\n" +
                " {\n" +
                "    Object object = new Object();\n" +
                "    object.KillAll();\n" +
                "    System.out.println(\"good bay\");\n" +
                " }");
        return totalMethodsLine * 1.00 / totalMethodsNbr;
    }

    /** TODO : EXAMPLE >>
     * We have :
     public static void main(String[] args) {
     Object object = new Object();

     object.KillAll();
     //  help me!!
     System.out.println("good bay");
     }

     * The body is :
     {
     Object object = new Object();
     object.KillAll();
     System.out.println("good bay");
     }

     * so in total for this method we have 5 lines in body
     * */

}
