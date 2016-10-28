package Bram

import Chisel._

class Bram extends Module {
  val io = new Bundle {
    val out = Bits(width = 4).asOutput
    val in = Bits(width = 4).asInput
  }
  io.out := io.in
}

object Main {
  def main(args: Array[String]) {
    chiselMainTest(args, () =>
        Module(new Bram)) {
      bl => new Tester(bl)
    }
  }
}
