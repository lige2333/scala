object ExtendTraitDemo01 {
  def main(args: Array[String]): Unit = {
    val clazz = new ScalaOuterClass()
    val clazz1 = new clazz.ScalaInnerClass
    val clazz2 = new ScalaOuterClass()
    val clazz13 = new clazz2.ScalaInnerClass
    clazz1.info()
    clazz1.test(clazz1)
    clazz13.test(clazz1)
  }
}

trait logger {
  this: Exception =>
  def log(): Unit = {
    println(getMessage())
  }
}

class ScalaOuterClass {
  myOutter =>
  class ScalaInnerClass {

    def info() = {
      println("name="+myOutter.name+"sal="+myOutter.sal)
    }
    def test(ic:ScalaOuterClass#ScalaInnerClass)={
      println(ic)
    }
  }
  var name = "scoot"
  private var sal = 30000.9

}