package Bram

import Chisel._

class Bram extends Module {

  def counter(max: UInt): UInt = {
    val x = Reg(init = UInt(0, max.getWidth))
    x := Mux(x === max, UInt(0), x + UInt(1))
    x
  }

  val io = new Bundle {
      val out = Bits(width = 4).asOutput
  }

  val ram = Mem(Bits(width=4), 8192, seqRead=true)
  val out = Reg(init=UInt(0))

  var count = Reg(init=UInt(0), next=counter(UInt(8192)))
  when (count(0)) {
    ram(count >> 1) := Bits(4)
  } .otherwise {
    out := ram(count >> 1)
  }
  io.out :=  out
}

object Main {
  def main(args: Array[String]) {
    chiselMainTest(args, () =>
        Module(new Bram)) {
      bl => new Tester(bl)
    }
  }
}
