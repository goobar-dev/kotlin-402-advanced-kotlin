import react.*
import react.dom.html.ReactHTML.p
import kotlinx.browser.window

external interface LanguageListProps: Props {
    var languages: List<String>
}

val ProgrammingLanguagesList = FC<LanguageListProps>() { props ->
    props.languages.forEach { language ->
        p {
            onClick = {
                window.alert("Clicked $language")
            }
            key = language
            +language
        }
    }
}