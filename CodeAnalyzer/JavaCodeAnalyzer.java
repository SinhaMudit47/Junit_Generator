package org.example;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.FileInputStream;

public class JavaCodeAnalyzer {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("C:\\Users\\MuditSinha\\IdeaProjects\\Conditions\\src\\NumberToWord.java");

        // Parse the Java code
        CompilationUnit cu = StaticJavaParser.parse(in);

        // Visit and print the methods
        cu.accept(new MethodVisitor(), null);
    }

    // Class to visit methods and print details
    private static class MethodVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration md, Void arg) {
            super.visit(md, arg);
            System.out.println("Method Name: " + md.getName());

            // Print arguments
            System.out.print("Arguments: ");
            for (Parameter parameter : md.getParameters()) {
                System.out.print(parameter.getType() + " " + parameter.getName() + ", ");
            }
            System.out.println();

            // Print return type
            System.out.println("Return Type: " + md.getType());

            // Print Javadoc
            md.getJavadoc().ifPresent(javadoc -> {
                System.out.println("Javadoc: " + javadoc.getDescription().toText());
            });

            System.out.println();
        }
    }
}