
class TextContent {
    private String text;

    // Constructor
    public TextContent(String text) {
        this.text = text;
    }

    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

class AudioContent {
    private byte[] audioData;


    public AudioContent(byte[] audioData) {
        this.audioData = audioData;
    }

    
    public byte[] getAudioData() {
        return audioData;
    }

    public void setAudioData(byte[] audioData) {
        this.audioData = audioData;
    }
}

class VideoContent {
    private byte[] videoData;


    public VideoContent(byte[] videoData) {
        this.videoData = videoData;
    }

    
    public byte[] getVideoData() {
        return videoData;
    }

    public void setVideoData(byte[] videoData) {
        this.videoData = videoData;
    }
}

class Data {
    private String type;
    private Object content;

    public Data(String type, Object content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public Object getContent() {
        return content;
    }
}

abstract class DataProcessor {
    public abstract void process(Data data);
}

class TextDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        System.out.println("Processing text data...");
        System.out.println("Text data processed.");
    }
}

class AudioDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        System.out.println("Processing audio data...");
        System.out.println("Audio data processed.");
    }
}

class VideoDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        System.out.println("Processing video data...");
        System.out.println("Video data processed.");
    }
}

class DataProcessorCreator {

    private DataProcessor processor;
    public void setProcessor(DataProcessor processor) {
        this.processor = processor;
    }

    public void processData(Data data) {
        processor.process(data);
    }
}

public class Ex_2 {
    public static void main(String[] args) {

        TextDataProcessor textProcessor = new TextDataProcessor();
        AudioDataProcessor audioProcessor = new AudioDataProcessor();
        VideoDataProcessor videoProcessor = new VideoDataProcessor();

        
        DataProcessorCreator creator = new DataProcessorCreator();


        creator.setProcessor(textProcessor);
        creator.processData(new Data("text", new TextContent("Sample text")));


        creator.setProcessor(audioProcessor);
        creator.processData(new Data("audio", new AudioContent(new byte[] {1, 2, 3})));


        creator.setProcessor(videoProcessor);
        creator.processData(new Data("video", new VideoContent(new byte[] {4, 5, 6})));
    }
}
