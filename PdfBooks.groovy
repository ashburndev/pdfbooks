import javax.swing.JFileChooser

def doit() {
    println """\
<!doctype htl>
<html lang="en">
  <head>
    <title>PDF Books</title>
  </head>
  <body>
    <h1>PDF Books</h1>
    <hr/>"""
    def dir = new File("C:\\LocalApps\\apache-tomcat-8.5.61\\webapps\\ROOT")
    dir.eachFile { file ->
        String fileName = file.name
        if (fileName.toLowerCase().endsWith(".pdf")) {
            String anchorTag = """<a href="${fileName}">""".padRight(60)
            Long fileSize = file.size()
            String fileSizeString = fileSize.toString().padLeft(10)
            Long lastMod = file.lastModified()
            String lastModString = new Date(lastMod).format("yyyy-MM-dd HH:mm:ss")
            println "    ${anchorTag} ${lastModString} ${fileSizeString} ${fileName} </a><br/>"
        }
    }
    println """\
  </body>
</html>"""
}

doit()



