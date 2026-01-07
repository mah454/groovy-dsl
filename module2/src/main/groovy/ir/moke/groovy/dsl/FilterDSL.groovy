package ir.moke.groovy.dsl

class FilterDSL {
    List<Closure<Boolean>> predicates = []

    def propertyMissing(String name) {
        new FieldExpr(field: name, predicates: predicates)
    }
}
