package com.example.tips_IntelliJ_IDEA.offer

import spock.lang.Specification


class OtherTestClass extends Specification {

    def "should manipulate string"() {
        expect:
        "hello".toUpperCase() == "HELLO"
    }

    def "should find max value with where clause"() {
        expect:
        Math.max(a, b) == result

        where:
        a | b || result
        1 | 2 || 2
        3 | 1 || 3
        5 | 5 || 5
    }

    def "should add values with where clause"() {
        expect:
        a + b == result

        where:
        a | b || result
        1 | 2 || 3
        3 | 4 || 7
        5 | 6 || 11
    }

    def "should add two numbers"() {
        expect:
        1 + 1 == 2
    }

    def "should get string length"() {
        expect:
        "Spock".length() == 5
    }

}