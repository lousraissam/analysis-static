package responses;

import visitors.ClassVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class Question3_5_7 {

    CompilationUnit parse;
    public static ClassVisitor classVisitor = new ClassVisitor();

    public Question3_5_7(){}

    public Question3_5_7(CompilationUnit parse){
        this.parse = parse;
        parse.accept(classVisitor);
    }

    public int printMethods(){
        for (var entry : classVisitor.getMethods().entrySet()) {
            System.out.println("\n* Class name : "+entry.getKey()+"");
            System.out.println("* Class methods :");
            for (MethodDeclaration method : entry.getValue()) {
                System.out.println("- "+method.getName().toString());
            }
        }
        return getTotalMethodsNbr();
    }

    public int getTotalMethodsNbr() {return classVisitor.getMethodsvV2().size();}
    public int getTotalVariablesNbr() {
        return classVisitor.getVariables().size();
    }




}
