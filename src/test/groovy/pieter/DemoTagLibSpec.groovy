package pieter

import grails.testing.web.taglib.TagLibUnitTest
import org.grails.plugins.web.DefaultGrailsTagDateHelper
import spock.lang.Specification

class DemoTagLibSpec extends Specification implements TagLibUnitTest<DemoTagLib> {

    Closure doWithSpring() {{ ->
        grailsTagDateHelper DefaultGrailsTagDateHelper
    }}

    void "test date format"() {
        given:
        def date
        Calendar cal = Calendar.instance
        cal.with {
            clear()
            set MONTH, JULY
            set YEAR, 1776
            set DATE, 4
            date = time
        }

        when:
        def output = applyTemplate('<tz:formatDate date="${date}"/>', [date: date])

        then:
        output == '1776-07-04'
    }
}
