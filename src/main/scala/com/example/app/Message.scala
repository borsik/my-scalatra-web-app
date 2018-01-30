package com.example.app

import org.json4s.DefaultFormats
import org.json4s.jackson.Json

class Message(val id:Int, val text:String) {
  override def toString: String = Json(DefaultFormats).write(this)
}
