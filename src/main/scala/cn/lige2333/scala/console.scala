package cn.lige2333.scala

import util.control.Breaks._
object console {
  def main(args: Array[String]): Unit = {
    breakable(
    for(i<- 1 to 9){
      for(j<- 1 to i) {
        print(j + "*" + i + "=" + j * i+"   ")
      }
      if(i==5){
        break()
      }
      println()
    })
  }
}
