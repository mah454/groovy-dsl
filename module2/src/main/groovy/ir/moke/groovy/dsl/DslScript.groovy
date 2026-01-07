package ir.moke.groovy.dsl

abstract class DslScript extends Script {
    PolicyDSL policy(Closure c) {
        def cfg = new PolicyDSL()
        c.delegate = cfg
        c.resolveStrategy = Closure.DELEGATE_FIRST
        c()
        return cfg
    }
}
