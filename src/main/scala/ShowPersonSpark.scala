import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object ShowPersonSpark {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val conf = new SparkConf()
    val spark = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()
    val person = spark.read.option("inferSchema", true).option("header", true).csv("data/person.csv")
    val address = spark.read.option("inferSchema", true).option("header", true).csv("data/address.csv")

    // 課題1: personテーブルとaddressテーブルのスキーマを表示してください

    // 課題2: 名前の一覧を表示してください

    // 課題3: 年齢が20歳以上の人数を出力してください

    // 課題4: personとaddressを結合して表示してください

    // 課題5: 都道府県毎の人数を表示してください

    // 課題6: personのageを年代に変換してください

    // 課題7: 都道府県毎に一番年齢の高い人を表示してください
  }
}
