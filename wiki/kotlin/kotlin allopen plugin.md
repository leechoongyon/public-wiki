# kotlin allopen plugin
- plugin.spring 에 allOpen 포함돼있음

```groovy
plugins {
    kotlin("plugin.spring") apply false
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

```
