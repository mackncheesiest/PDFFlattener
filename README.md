## PDF Flattener

Basic Java application that allows you to feed in an arbitrary PDF and get back a version that has been "flattened".

In my case, I just needed a utility that stripped out digital signature related features that were preventing me from uploading an official transcript PDF to an online application. The application wouldn't accept the PDF because it was digitally signed, and their recommendation of "use the print-to-pdf feature" was unsatisfying because a "PRINTED" watermark was stamped all over that copy.

So I found [itextpdf](https://itextpdf.com/) and threw together this utility. Needless to say, I've only tested this on my one specific use case and don't plan to actively develop it. However, if it can help anyone else in a situation similar to what I dealt with, then it's worth it.

### Usage
In using this utility, there are two options:
* Download the release jar from the releases tab, and, assuming you have Java installed and it's on your shell path, you can just invoke it with `java -jar pdf_flattener.jar input_file.pdf output_file.pdf`.
* Clone the repository, build it from scratch with `mvn clean package`, and use the jar ending in `-jar-with-dependencies.jar` from `/target` in the same manner.