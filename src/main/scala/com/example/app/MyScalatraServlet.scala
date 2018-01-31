package com.example.app

import org.json4s.{DefaultFormats, Formats}
import org.scalatra._
import org.scalatra.json._

class MyScalatraServlet extends ScalatraServlet with JacksonJsonSupport {
  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  var messageMap = new MessageMap()

  get("/") {
    views.html.hello()
  }

  get("/messages") {
    messageMap.map
  }

  get("/messages/:id") {
    val id = Integer.parseInt(params("id"))
    messageMap.get(id)
  }

  post("/messages") {
    val message = parsedBody.extract[Message]
    messageMap.add(message)
  }

  delete("/messages/:id") {
    val id = Integer.parseInt(params("id"))
    messageMap.remove(id)
    messageMap.map
  }

  put("/messages/:id") {
    val id = Integer.parseInt(params("id"))
    val text = (parsedBody \ "text").extract[String]
    messageMap.update(id, text)
  }

}
