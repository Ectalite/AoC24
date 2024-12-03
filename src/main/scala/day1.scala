import os.read

@main def day1(): Unit =
  val lines = read.lines(os.resource / "input1.txt")

  val input =
    for line <- lines
        leftNumber = line.takeWhile(_ != ' ')
        rightNumber = line.dropWhile(_ != ' ').trim
    yield (leftNumber, rightNumber)

  val leftList = input.map((a,_) => a.toInt).toList.sorted
  val rightList = input.map((_,b) => b.toInt).toList.sorted

  val sortedList = leftList.zip(rightList)
  val distance = {
    for number <- sortedList
      yield (number._1 - number._2).abs
  }.sum
  println("Distance:" + distance)

  val similarity = {
    for number <- leftList
    yield rightList.count(i => i == number) * number
  }.sum

  println("Similarity:" + similarity)
