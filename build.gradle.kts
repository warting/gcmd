group = "se.warting.gcmd"
version = "1.0-SNAPSHOT"

// take a list of bash commands from the command line separeted by &
//val cmdTasks = project.findProperty("command") as String
val cmdTasks = (project.findProperty("command") as String).split("&")

// register root task
tasks.register("runAll") {
    dependsOn(cmdTasks.map { tasks.getByName("run$it") })
}
// Run each task one after another
cmdTasks.forEach {
    tasks.register("run$it") {
        doLast {
            exec {
                commandLine("bash", "-c", it)
            }
        }
    }
}