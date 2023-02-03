package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private static List<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        LocalProcessor.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) throws IllegalStateException {

        stringArrayList = new LinkedList<>(stringList);

        for (String s : stringArrayList) {
            try
            {
                System.out.println(s.hashCode());
            }
            catch (Exception e) {
                throw new IllegalStateException(super.toString(), e);
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) throws RuntimeException {
        StringBuilder builder = new StringBuilder();

        for (String s : stringList) {
            builder.append(s).append(" ");
        }

        return builder.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        StringBuilder builder = new StringBuilder();
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                builder.append(informationScanner.nextLine());
            }
        processorVersion = builder.toString();
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + stringArrayList.hashCode();
        return result;
    }
}
