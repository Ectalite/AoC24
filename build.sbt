ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.1"

lazy val root = (project in file("."))
  .settings(
    name := "AdventOfCode24",
    libraryDependencies += "org.scala-lang" %% "toolkit" % "0.6.0"
  )
