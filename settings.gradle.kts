rootProject.name = "spring-course"
include("spring01:lecture")
include("spring01:task")
findProject(":spring01:task")?.name = "task"
