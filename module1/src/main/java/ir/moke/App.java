package ir.moke;

import groovy.lang.GroovyShell;
import ir.moke.groovy.dsl.DslScript;
import ir.moke.groovy.dsl.ServerConfig;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.File;
import java.io.IOException;

public class App {
    static void main(String[] args) throws IOException {
        CompilerConfiguration cc = new CompilerConfiguration();
        cc.setScriptBaseClass(DslScript.class.getName());

        GroovyShell shell = new GroovyShell(cc);
        ServerConfig config = (ServerConfig) shell.evaluate(new File("config/server.dsl"));
        System.out.println(config);
    }
}
