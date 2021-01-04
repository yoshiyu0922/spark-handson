# Sparkハンズオン

## 概要

- 基本的なSparkとScalaのプログラミングを理解するためのハンズオン
- ハンスオン内容 => [HANDSON.md](HANDSON.md)

## Environment

- java 1.8
- sbt 1.2.7
- scala 2.11.12
- Spark 2.4.7

## 環境構築

## java1.8のインストール

#### Macの場合

- homebrewでインストールできるが、バージョンは1.8である必要がある
- 1.8はライセンスの関係で利用不可になっているので、OpenJDKを利用する
```shell
$ brew install --cask adoptopenjdk8
```
- 余裕があれば、バージョン管理ツール `jenv` をインストールすると良いかもしれない。
- javaコマンドでバージョンを確認できればインストール完了

```shell
$ java -version                                                                                                                                                                                                                      
java version "1.8.0_202"
Java(TM) SE Runtime Environment (build 1.8.0_202-b08)
Java HotSpot(TM) 64-Bit Server VM (build 25.202-b08, mixed mode)
```

#### Windowsの場合

- [公式サイト](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) からexeファイルをダウンロードして実行する
- javaコマンドでバージョンを確認できればインストール完了

```shell
$ java -version                                                                                                                                                                                                                      
java version "1.8.0_202"
Java(TM) SE Runtime Environment (build 1.8.0_202-b08)
Java HotSpot(TM) 64-Bit Server VM (build 25.202-b08, mixed mode)
```


### sbtのインストール

- [公式サイト](https://www.scala-sbt.org/1.x/docs/ja/Setup.html) を参考にインストールをする
- インストール後に以下の手順でビルドが成功し、outフォルダに `spark-handson.jar` が作成されていればインストールは完了

```shell
$ cd /spark-handson

$ sbt assembly
...（省略）...
[info] Assembly up to date: ...(省略).../spark-handson/out/spark-handson.jar
[success] Total time: 3 s, completed 2021/01/04 15:15:26
```

### Sparkのインストール

- [公式サイト](https://spark.apache.org/downloads.html) よりバイナリファイルをダウンロード
    - Choose a Spark release: 2.4.7 (Sep 12 2020)
    - Choose a package type: Pre-built for Apache Hadoop 2.7
- 「Download Spark: spark-2.4.7-bin-hadoop2.7.tgz」をクリックするとミラーサイトに遷移するので、そこからダウンロードする

#### Macの場合

terminalを開き、以下を実行
```shell
$ cd ~

$ mkdir spark-2.4.7

$ tar xzf (ダウンロード先フォルダ)/spark-2.4.7-bin-hadoop2.7.tgz -C ~/spark-2.4.7/ --strip-components=1

$ ls spark-2.4.7                                                                                                                                                                                                                                           
# 解凍したファイルが表示される

$ export SPARK_HOME=$HOME/spark-2.4.7

$ export PATH=$SPARK_HOME/bin:$PATH
```

#### Windowsの場合

- 解凍ツールでダウンロードしたファイルを展開する（Chromeでダウンロードした方が良いかも）
- 展開したファイルを任意の場所（= インストール先のパス）に移動（ユーザフォルダとか）
- winutils.exeを以下のリンクからダウンロード
  - https://github.com/steveloughran/winutils/blob/master/hadoop-2.7.1/bin/winutils.exe
  - 解凍先Sparkフォルダ/binフォルダに配置
- コントロールパネルからシステム環境変数を追加
  - システム環境変数にHADOOP_HOMEを作成してSparkのインストール先のパスを指定
  - ユーザ環境変数Path（既にある）に「 Sparkのインストール先のパス¥bin」を指定

#### 動作確認


- 「spark-shell」を実行して以下のように出力されればインストールは完了

```shell
$ spark-shell
# ...（省略）...
Welcome to
      ____              __
     / __/__  ___ _____/ /__
    _\ \/ _ \/ _ `/ __/  '_/
   /___/ .__/\_,_/_/ /_/\_\   version 2.4.7
      /_/
         
Using Scala version 2.11.12 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_202)
Type in expressions to have them evaluated.
Type :help for more information.
```
