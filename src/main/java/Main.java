public class Main {

    public static void main(String[] args) {
        PeopleCounter countPeople = new PeopleCounter();
        ReadingFile readingFile = new ReadingFile();
        readingFile.fileRead();
        readingFile.convertList(ReadingFile.input);
        countPeople.maxCounting(ReadingFile.arrivalTime, ReadingFile.careTime);
    }
}
