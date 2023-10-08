package responses;

import visitors.MethodInvocationVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import java.util.List;

public class Question14 {

    public MethodInvocationVisitor createMethodVisitor(MethodDeclaration method) {
        MethodInvocationVisitor methodVisitor = new MethodInvocationVisitor(method);
        Block block = method.getBody();
        block.accept(methodVisitor);
        return methodVisitor;
    }

    public String callGraph() {
        String data = "";

        List<MethodDeclaration> methods = Question3_5_7.classVisitor.getMethodsvV2();

        if (methods.size() > 0) {
            data = data + "\n" + "Methods invocations >>\n\n";
            for (MethodDeclaration method : methods) {
                data = data + "Method name : " + method.getName() ;
                MethodInvocationVisitor methodVisitor = createMethodVisitor(method);
                data = data + methodVisitor.callGraph();
                data = data + "---------------------------------\n";
            }
        }
        return data;
    }

}
