package cn.lige2333 {
  package scala {

    class Person1 {
       val name = "nick"

       def play(message: String): Unit = {
        println(this.name + " " + message)
      }
    }
    class gay extends Person1 {
      override def play(message: String): Unit = {
        println("nimasi")
      }

    }
    object Test100{
      def main(args: Array[String]): Unit = {
        println("name"+name)
        sayHi()
        val gay = new gay
        gay.play("666")
      }
    }

  }

  package object scala {
    val name = "king"

    def sayHi(): Unit = {
      println("package object scala sayhi")
    }

  }

}




