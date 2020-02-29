package com.ddam40.kia.chapter11


class Greeter(val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting, $name")
    }
}

fun main() {
    val br = Greeter("James")
    br("Hello")

    val i1 = Issue("I1", "IDEAA", "Bug", "Majro", "Save")
    val predicate = ImportantIssuesPredicate("IDEAA")

    val dependencies = DependencyHandler()
    dependencies.compile("com.spring.io")
    dependencies {
        compile("com.zip")
        compile("io.des")
    }
}

data class Issue(
    val id: String, val project: String, val type: String,
    val priority: String, val description: String
)

class ImportantIssuesPredicate(val project: String): (Issue) -> Boolean {
    override fun invoke(issue: Issue): Boolean {
        return issue.project == project && issue.isImportant()
    }

    private fun Issue.isImportant(): Boolean = type == "Bug" && (priority == "Major" || priority == "Critical")
}

class DependencyHandler {
    fun compile(dependency: String) {
        println("Add dependency in $dependency")
    }
    operator fun invoke(body: DependencyHandler.() -> Unit) {
        body()
    }
}
