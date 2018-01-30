package com.example.app

import scala.collection._
class MessageMap {
  var map: Map[Int, Message] = Map()

  init()

  def init(): Unit = {
    this.add(1, "Sample text")
  }

  def add(id: Int, text: String) = {
    val message = new Message(id, text)
    map += (id -> message)
  }

  def add(message: Message) = {
    map += (message.id -> message)
  }

  def get(id: Int): Message = {
    map(id)
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
