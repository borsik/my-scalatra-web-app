package com.example.app

import scala.collection._
class MessageMap {
  var map: Map[Int, Message] = Map()

  init()

  def init(): Unit = {
    this.add(1, "Sample text")
    this.add(2, "Another text")
    this.add(3, "Yet another text")
  }

  def add(id: Int, text: String) = {
    val message = new Message(id, text)
    map += (id -> message)
  }

  def add(message: Message) = {
    map += (message.id -> message)
  }

  def get(id: Int): Message = {
    map.getOrElse(id, null)
  }

  def remove(id: Int) = {
    map -= id
  }

  def update(id: Int, message: Message) = {
    map += (id -> message)
  }

  def update(id: Int, text: String) = {
    add(id, text)
  }

  override def toString: String = s"Map :: ${map}"
}
