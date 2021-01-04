# Spark ハンズオン

### 前提条件

- ShowPersonSparkオブジェクトを作成済み
- ShowPersonSparkオブジェクトに以下の課題の対応をしてください

### 実行方法

以下の通りにコマンドを実行する
- `sbt assembly` でjarを作成する
- `spark-submit` でSparkを実行する

```shell
$ cd spark-handson

$ sbt assembly

$ spark-submit --class ShowPersonSpark ./out/spark-handson.jar 
```

### 課題1: personテーブルとaddressテーブルのスキーマを表示してください

- 表示件数はデフォルトのままで良いです

### 課題2: 名前の一覧を表示してください

- 表示件数はデフォルトのままで良いです

### 課題3: 年齢が20歳以上の人数を出力してください

- 表示件数はデフォルトのままで良いです

### 課題4: personとaddressを結合して表示してください

- 表示件数はデフォルトのままで良いです

### 課題5: 都道府県毎の人数を表示してください

- personとaddressを結合してください
- 47都道府県全てを表示してください

### 課題6: personのageを年代に変換してください

- 「24 -> 20代, 34 -> 30代」のように変換する
- mapPartitionsを使って変換してください
- 表示件数はデフォルトのままで良いです

### 課題7: 都道府県毎に一番年齢の高い人を表示してください

- Window関数を使ってください
- 47都道府県全てを表示してください
