package ir.moke;

import groovy.lang.GroovyShell;
import ir.moke.groovy.dsl.DslScript;
import ir.moke.groovy.dsl.PolicyDSL;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.File;
import java.io.IOException;

public class App {
    static void main(String[] args) throws IOException {
        CompilerConfiguration cc = new CompilerConfiguration();
        cc.setScriptBaseClass(DslScript.class.getName());

        GroovyShell shell = new GroovyShell(cc);
        PolicyDSL policyDSL = (PolicyDSL) shell.evaluate(new File("config/policy.dsl"));
        String json = "[ { \"name\": \"Mahdi\", \"family\": \"Sheikh Hosseini\", \"age\": 22, \"address\": \"Pardis\" }, { \"name\": \"Ali\", \"family\": \"Mohammadi\", \"age\": 45, \"address\": \"Tehran\" }, { \"name\": \"Sara\", \"family\": \"Ahmadi\", \"age\": 28, \"address\": \"Tehran\" }, { \"name\": \"Reza\", \"family\": \"Hosseini\", \"age\": 55, \"address\": \"Shiraz\" } ]";
        Object output = policyDSL.apply(json);
        System.out.println(output);
    }
}
