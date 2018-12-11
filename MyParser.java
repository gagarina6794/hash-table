import java.io.*;
import java.util.Objects;

public class MyParser {
    private File file;

    public MyParser(File file) {
        Objects.requireNonNull(file, "file must not be null");
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public StringBuilder getContent(int startUnicode, int endUnicode) {
        StringBuilder output = new StringBuilder();
        BufferedInputStream bis = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            int data;
            while ((data = bis.read()) > 0) {
                if (data > startUnicode && data < endUnicode) {
                    output.append((char) data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return output;
    }


    public void saveContent(StringBuilder content) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            for (int i = 0; i < content.length(); i++) {
                bos.write(content.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (bos != null) {
                    bos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

