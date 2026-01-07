package ir.moke.groovy.dsl

class FieldExpr implements Comparable {
    String field
    List<Closure<Boolean>> predicates

    @Override
    int compareTo(Object value) {
        predicates << { row -> row[field] > value }
        return 1
    }

    def gt(value) {
        predicates << { it[field] > value }
    }

    def lt(value) {
        predicates << { it[field] < value }
    }

    def eq(value) {
        predicates << { it[field] == value }
    }
}
