package com.knoldus
import java.io.File
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureApiExample extends App {

    def directoryPrinter(path:String): Unit ={
      val fileObj: File = new File(path)
      val fileList=fileObj.listFiles
      for (file<-fileList){
        if(file.isFile) print(file.getPath+" | ") else Future{directoryPrinter(file.getPath)}
      }
    }
    directoryPrinter("/home/knoldus/Music")
}
