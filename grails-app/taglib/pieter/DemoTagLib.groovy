package pieter

class DemoTagLib {
    static defaultEncodeAs = [taglib:'html']

    static namespace = 'tz'

    def formatDate = { attrs ->
        out << g.formatDate(date: attrs.date, format: 'yyyy-MM-dd')
    }
}
