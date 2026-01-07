package ir.moke.groovy.dsl


import groovy.json.JsonSlurper

class PolicyDSL {
    List<Closure<Boolean>> filters = []

    def filter(Closure c) {
        def filter = new FilterDSL()
        c.delegate = filter;
        c.resolveStrategy = Closure.DELEGATE_FIRST
        c()
        filters.addAll(filter.predicates)
    }

    def apply(List data) {
        data.findAll { item -> filters.every { it(item) } }
    }

    def apply(String json) {
        def data = new JsonSlurper().parseText(json)
        data.findAll { item -> filters.every { it(item) } }
    }
}
