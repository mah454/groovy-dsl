package ir.moke.groovy.dsl

abstract class DslScript extends Script {
    ServerConfig server(Closure c) {
        def cfg = new ServerConfig()
        c.delegate = cfg
        c.resolveStrategy = Closure.DELEGATE_FIRST
        c()
        return cfg
    }
}
