package visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class PackageVisitor extends ASTVisitor  {

    List<TypeDeclaration> classes = new ArrayList<>();

    public boolean visit(TypeDeclaration node) {
        if (!node.isInterface()) classes.add(node);
        return super.visit(node);
    }

    public List<TypeDeclaration> getClasses() {
        return classes;
    }

}