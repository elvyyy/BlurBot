package by.bsuir.blurbot.service;

import lombok.extern.slf4j.Slf4j;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class BlurService {

    private static final BlurService INSTANCE = new BlurService();

    public static BlurService getInstance() {
        return INSTANCE;
    }

    private BlurService() {
    }



    public File blurFaces(File file) {
        Mat img = Imgcodecs.imread(file.getAbsolutePath());
        String cmlFile = "src/main/resources/lbpcascade_frontalface.xml";
        CascadeClassifier classifier = new CascadeClassifier(cmlFile);

        MatOfRect faces = new MatOfRect();
        Mat rectMat = new Mat();
        Mat gray = new Mat();

        Imgproc.cvtColor(img, gray, Imgproc.COLOR_RGB2GRAY);
        Imgproc.equalizeHist(gray, gray);
        img.copyTo(rectMat);

        classifier.detectMultiScale(gray, faces, 1.2, 3, Objdetect.CASCADE_SCALE_IMAGE);

        log.info("Detected faces: {}", faces.toArray().length);
        for (Rect rect : faces.toArray()) {
            Mat region = img.submat(rect);
            int height = region.height();
            int width = region.width();
            if (height % 2 == 0) {
                height = -1;
            }
            if (width % 2 == 0) {
                width = -1;
            }
            //Imgproc.rectangle(rectMat, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 3);
            Imgproc.GaussianBlur(region, region, new Size(height, width), 57, 57);

        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String pathToStore = String.format("src/main/resources/%s.jpg", LocalDateTime.now().format(formatter));
        Imgcodecs.imwrite(pathToStore, img);
//        Imgcodecs.imwrite("src/main/resources/rect.jpg", rectMat);
        return new File(pathToStore);
    }
}
