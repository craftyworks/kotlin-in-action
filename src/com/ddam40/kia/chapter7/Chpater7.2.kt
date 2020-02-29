package com.ddam40.kia.chapter7

import jdk.nashorn.internal.runtime.PropertyListeners
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

data class Email(val address: String)

data class NewPerson(val name: String) {
    val emails: List<Email> by lazy {loadEmails()}

    private fun loadEmails(): List<Email> {
        println("loading emails")
        return listOf(Email("$name@gmail.com"))
    }
}

fun main22(): Unit {
    val person = NewPerson("James")
    println("Person : $person")

    println("Person : $person, mail: ${person.emails}")
    println("mail: ${person.emails}")
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }
    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class NeoPerson(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    val observer = {
        prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}

class ObservalbleProperty(
    var propValue: Int, val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(p: NeoPerson, prop: KProperty<*>): Int = propValue

    operator fun setValue(p: NeoPerson, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

fun main() {
    val p = NeoPerson("James", 24, 3_000_000)
    p.addPropertyChangeListener(PropertyChangeListener { evt ->
        println("Property ${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}")
    })
    p.age = 30
    println("Person ${p.age}")
}