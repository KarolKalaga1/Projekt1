package project1;

/**
 * Class is used to store information, about the words selected from a file, and
 * describes it.
 */
public class WordStruct {

    /**
     * Word keep word.
    */
    private String Word;
     /**
     * FieldId keep individual number words.
    */
    private int FileId;
     /**
     * FieldId keep Occurrence words.
    */
    private int Occurrence;

    public WordStruct(String word, int fileid, int occurrance) {
        Word = word;
        FileId = fileid;
        Occurrence = occurrance;
    }

    /**
     * used to set Occurrence words in the set.
     *
     * @param Occurrence to set.
     */
    public void SetOccurence(int Occurrence) {
        this.Occurrence += Occurrence;
    }

    /**
     * used to get Occurrence words in the set.
     *
     * @return Occurrence.
     */
    public int getOccurence() {
        return Occurrence;
    }

    /**
     * @return the Word.
     */
    public String getWord() {
        return Word;
    }

    /**
     * @param Word the Word to set.
     */
    public void setWord(String Word) {
        this.Word = Word;
    }

    /**
     * @return the FileId.
     */
    public int getFileId() {
        return FileId;
    }

    /**
     * @param FileId the FileId to set.
     */
    public void setFileId(int FileId) {
        this.FileId = FileId;
    }

    /**
     * toString this founction can be overload and return more informations.
     *
     * @return Word.
     */
    @Override
    public String toString() {
        return this.getWord();
    }

}
