import Dependencies._

lazy val root = (project in file("."))
  .settings(
    scalaVersion := "2.11.12",
    version := "0.1",
    name := "spark-handson",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "org.apache.spark" % "spark-core_2.11" % "2.4.4" % Provided,
      "org.apache.spark" % "spark-sql_2.11" % "2.4.4" % Provided,
      "org.apache.spark" % "spark-hive_2.11" % "2.4.4" % Provided,
      "com.holdenkarau" %% "spark-testing-base" % "2.4.4_0.14.0" % Test
    ),
    assemblyOption in assembly := (assemblyOption in assembly).value
      .copy(includeScala = false),
    assemblyMergeStrategy in assembly := {
      case PathList("log4j.properties", xs @ _*) => MergeStrategy.discard
      case PathList("sample", xs @ _*)           => MergeStrategy.discard
      case x =>
        val oldStrategy = (assemblyMergeStrategy in assembly).value
        oldStrategy(x)
    },
    assemblyOutputPath in assembly := file(s"out/${name.value}.jar")
  )
