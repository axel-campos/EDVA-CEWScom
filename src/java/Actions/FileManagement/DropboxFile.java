package Actions.FileManagement;

import java.text.DecimalFormat;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Axel
 */
public class DropboxFile {

    private String name;
    private long size;
    private String extension;
    private String mimeType;

    public DropboxFile(String name, long size, String extension, String mimeType) {
        this.name = name;
        this.size = size;
        this.extension = extension;
        this.mimeType = mimeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public FileListTable toFileListTable() {
        return new FileListTable(
            FilenameUtils.getBaseName(this.name),
            readableFileSize(this.size),
            this.mimeType + " (." + this.extension + ")"
        );
    }

    private static String readableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[]{"B", "kB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }
}
