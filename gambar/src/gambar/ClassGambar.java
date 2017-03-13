/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gambar;

import java.awt.Color;
//import java.awt.Graphics2D;
import java.awt.Image;
//import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Aditya PN
 */
public class ClassGambar {
 // Variabel Global
public ImageIcon SourceIcon; public Image SourceImage;
public ImageIcon ScaleIcon; public Image ScaleImage;
public Image ResultImage; public Image ScaleResultImage;
public ImageIcon ScaleResultIcon;
public String URLImage;
public boolean ScaledFlag=false; 
public BufferedImage SourceBuffer; public BufferedImage ResultBuffer; 
public long sWidth;
public long sHeight;

//konstruktor
ClassGambar(String Url, long width, long height){
URLImage=Url;
if(width<=0 ||height <=0)
{
ScaledFlag=false;
}
else
{
ScaledFlag=true;
sWidth=width;
sHeight=height;
}
}

public ImageIcon GetIcon(){ if(!URLImage.equals(""))
{
SourceIcon = new ImageIcon(URLImage); SourceImage = SourceIcon.getImage(); try
{
SourceBuffer=ImageIO.read(new File(URLImage));
}
catch(IOException x)
{
JOptionPane.showMessageDialog(null, x.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
}
System.out.println(SourceIcon.getIconWidth());
if(ScaledFlag)
{
ScaleImage=SourceImage.getScaledInstance((int)sWidth, (int)sHeight,
Image.SCALE_DEFAULT);
ScaleIcon=new ImageIcon(ScaleImage); return ScaleIcon;
}
else
{
return SourceIcon;
}
}
else
{
return null;
}
}


// fungsi Grayscale
public void Grayscale(){ ResultBuffer=deepCopy(SourceBuffer);
long tWidth=ResultBuffer.getWidth(); long tHeight=ResultBuffer.getHeight();
long x,y;
int RGB,Red,Green,Blue,Gray;
Color tWarna; for(x=0;x<tWidth;x++)
{
for(y=0;y<tHeight;y++)
{
RGB=ResultBuffer.getRGB((int)x, (int)y);
tWarna=new Color(RGB);
Red=tWarna.getRed();
Green=tWarna.getGreen();
Blue=tWarna.getBlue();
Gray=(Red+Green+Blue)/3;
tWarna=new Color(Gray,Gray,Gray);
ResultBuffer.setRGB((int)x, (int)y, tWarna.getRGB());
}
}
ResultImage=(Image) ResultBuffer;
ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
Image.SCALE_DEFAULT);
ScaleResultIcon=new ImageIcon(ScaleResultImage);
}


// fungsi Biner
public void Biner(){ ResultBuffer=deepCopy(SourceBuffer);
long tWidth=ResultBuffer.getWidth(); long tHeight=ResultBuffer.getHeight();
long x,y;
int RGB,Red,Green,Blue,Gray;
Color tWarna; for(x=0;x<tWidth;x++)
{
for(y=0;y<tHeight;y++)
{
RGB=ResultBuffer.getRGB((int)x, (int)y);
tWarna=new Color(RGB);
Red=tWarna.getRed();
Green=tWarna.getGreen();
Blue=tWarna.getBlue();
Gray=(Red+Green+Blue)/3;
if (Gray<=128)
{
    Gray=0;
}
else
{
Gray=255;
}
tWarna=new Color(Gray,Gray,Gray);
ResultBuffer.setRGB((int)x, (int)y, tWarna.getRGB());
}
}
ResultImage=(Image) ResultBuffer;
ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
Image.SCALE_DEFAULT);
ScaleResultIcon=new ImageIcon(ScaleResultImage);
}


// fungsi Default
public void Default(){ ResultBuffer=deepCopy(SourceBuffer);
long tWidth=ResultBuffer.getWidth(); long tHeight=ResultBuffer.getHeight();
long x,y;
int RGB,Red,Green,Blue;
Color tWarna; for(x=0;x<tWidth;x++)
{
for(y=0;y<tHeight;y++)
{
RGB=ResultBuffer.getRGB((int)x, (int)y);
tWarna=new Color(RGB);
Red=tWarna.getRed();
Green=tWarna.getGreen();
Blue=tWarna.getBlue();
tWarna=new Color(Red,Green,Blue);
ResultBuffer.setRGB((int)x, (int)y, tWarna.getRGB());
}
}
ResultImage=(Image) ResultBuffer;
ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
Image.SCALE_DEFAULT);
ScaleResultIcon=new ImageIcon(ScaleResultImage);
}

// fungsi Brightness
public void Brightness(int t){ ResultBuffer=deepCopy(SourceBuffer);
long tWidth=ResultBuffer.getWidth(); long tHeight=ResultBuffer.getHeight();
long x,y;
int RGB,Red,Green,Blue, c;
c=t-50;
Color tWarna; for(x=0;x<tWidth;x++)
{
for(y=0;y<tHeight;y++)
{
RGB=ResultBuffer.getRGB((int)x, (int)y);
tWarna=new Color(RGB);
Red=tWarna.getRed()+c;
Green=tWarna.getGreen()+c;
Blue=tWarna.getBlue()+c;
if(Red>255){    Red=255;}
else if(Red<0){    Red=0;}
if(Green>255){    Green=255;}
else if(Green<0){    Green=0;}
if(Blue>255){    Blue=255;}
else if(Blue<0){    Blue=0;}
tWarna=new Color(Red,Green,Blue);
ResultBuffer.setRGB((int)x, (int)y, tWarna.getRGB());
}
}
ResultImage=(Image) ResultBuffer;
ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
Image.SCALE_DEFAULT);
ScaleResultIcon=new ImageIcon(ScaleResultImage);
}

// fungsi Negatif
public void Negatif(){ ResultBuffer=deepCopy(SourceBuffer);
long tWidth=ResultBuffer.getWidth(); long tHeight=ResultBuffer.getHeight();
long x,y;
int RGB,Red,Green,Blue;
Color tWarna; for(x=0;x<tWidth;x++)
{
for(y=0;y<tHeight;y++)
{
RGB=ResultBuffer.getRGB((int)x, (int)y);
tWarna=new Color(RGB);
Red=tWarna.getRed();
Green=tWarna.getGreen();
Blue=tWarna.getBlue();
tWarna=new Color(255-Red,255-Green,255-Blue);
ResultBuffer.setRGB((int)x, (int)y, tWarna.getRGB());
}
}
ResultImage=(Image) ResultBuffer;
ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
Image.SCALE_DEFAULT);
ScaleResultIcon=new ImageIcon(ScaleResultImage);
}

//Flip Vertikal
public void flipV(){
    ResultBuffer=deepCopy(SourceBuffer);
    BufferedImage img=new BufferedImage(SourceBuffer.getWidth(),
    SourceBuffer.getHeight(), BufferedImage.TYPE_INT_RGB);
    for(int y=0; y<SourceBuffer.getHeight();y++){
        for(int x=0; x<SourceBuffer.getWidth();x++){
            img.setRGB(x, y, SourceBuffer.getRGB(x, SourceBuffer.getHeight()-1-y));
        }
    }
    ResultImage=img;
    ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
            Image.SCALE_DEFAULT);
    ScaleResultIcon=new ImageIcon(ScaleResultImage);
}

//Flip Horizontal
public void flipH(){
    ResultBuffer=deepCopy(SourceBuffer);
    BufferedImage img=new BufferedImage(SourceBuffer.getWidth(),
    SourceBuffer.getHeight(), BufferedImage.TYPE_INT_RGB);
    for(int y=0; y<SourceBuffer.getHeight();y++){
        for(int x=0; x<SourceBuffer.getWidth();x++){
            img.setRGB(x, y, SourceBuffer.getRGB(SourceBuffer.getWidth()-1-x, y));
        }
    }
    ResultImage=img;
    ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
            Image.SCALE_DEFAULT);
    ScaleResultIcon=new ImageIcon(ScaleResultImage);
}

//ZoomIn
public void zoomin(){
    ResultBuffer=deepCopy(SourceBuffer);
    ResultImage=(Image) ResultBuffer;
    sWidth=sWidth*2;
    sHeight=sHeight*2;
    ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight, 
            Image.SCALE_DEFAULT);
    ScaleResultIcon=new ImageIcon(ScaleResultImage);
}

//ZoomOut
public void zoomout(){
    ResultBuffer=deepCopy(SourceBuffer);
    ResultImage=(Image) ResultBuffer;
    sWidth=sWidth/2;
    sHeight=sHeight/2;
    ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight, 
            Image.SCALE_DEFAULT);
    ScaleResultIcon=new ImageIcon(ScaleResultImage);
}

//90D
public void rotate90(){
    ResultBuffer=deepCopy(SourceBuffer);
    BufferedImage img=new BufferedImage(SourceBuffer.getHeight(),
    SourceBuffer.getWidth(), BufferedImage.TYPE_INT_RGB);
    for(int y=0; y<SourceBuffer.getWidth();y++){
        for(int x=0; x<SourceBuffer.getHeight();x++){
            img.setRGB(x, y, SourceBuffer.getRGB(y, SourceBuffer.getHeight()-1-x));
        }
    }
    ResultImage=img;
    ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
            Image.SCALE_DEFAULT);
    ScaleResultIcon=new ImageIcon(ScaleResultImage);
}
//180D
public void rotate180(){
    ResultBuffer=deepCopy(SourceBuffer);
    BufferedImage img=new BufferedImage(SourceBuffer.getWidth(),
    SourceBuffer.getHeight(), BufferedImage.TYPE_INT_RGB);
    for(int y=0; y<SourceBuffer.getHeight();y++){
        for(int x=0; x<SourceBuffer.getWidth();x++){
            img.setRGB(x, y, SourceBuffer.getRGB(SourceBuffer.getWidth()-1-x, SourceBuffer.getHeight()-1-y));
        }
    }
    
    ResultImage=img;
    ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
            Image.SCALE_DEFAULT);
    ScaleResultIcon=new ImageIcon(ScaleResultImage);
}
//270D
public void rotate270(){
    ResultBuffer=deepCopy(SourceBuffer);
    BufferedImage img=new BufferedImage(SourceBuffer.getHeight(),
    SourceBuffer.getWidth(), BufferedImage.TYPE_INT_RGB);
    for(int y=0; y<SourceBuffer.getWidth();y++){
        for(int x=0; x<SourceBuffer.getHeight();x++){
            img.setRGB(x, y, SourceBuffer.getRGB(SourceBuffer.getWidth()-1-y, x));
        }
    }
    ResultImage=img;
    ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
            Image.SCALE_DEFAULT);
    ScaleResultIcon=new ImageIcon(ScaleResultImage);
}

/*
public void freerotate(int angle){
    ResultBuffer=deepCopy(SourceBuffer);
    BufferedImage img=new BufferedImage(SourceBuffer.getWidth(),
    SourceBuffer.getHeight(), BufferedImage.TYPE_INT_RGB);
    int w=SourceBuffer.getWidth();
    int h=SourceBuffer.getHeight();
  

    Graphics2D g2 = ResultBuffer.createGraphics();
    g2.rotate(Math.toRadians(45), w/2, h/2);  
    g2.drawImage(ResultBuffer,null,0,0);

    //    Graphics2D g2 = ResultBuffer.createGraphics();
    //
    //    double x = (h - w)/2.0;
    //    double y = (w - h)/2.0;
    //    AffineTransform at = AffineTransform.getTranslateInstance(x, y);
    //
    //    at.rotate(Math.toRadians(45), w/2.0, h/2.0);
    //    g2.drawImage(ResultBuffer, at, null);
    //    g2.dispose();
    
    ScaleResultImage=ResultBuffer.getScaledInstance((int)sWidth, (int)sHeight,
            Image.SCALE_DEFAULT);
    ScaleResultIcon=new ImageIcon(ScaleResultImage);
}
*/



static BufferedImage deepCopy(BufferedImage bi){ ColorModel cm=bi.getColorModel();
boolean isAlphaPremultiplied = cm.isAlphaPremultiplied(); WritableRaster raster = bi.copyData(null);
return new BufferedImage(cm,raster,isAlphaPremultiplied,null);
}
public void SaveImage(String url)
{
File tFile= new File(url); System.out.println(url); try
{
String fileName = tFile.getCanonicalPath(); if(!fileName.endsWith(".jpeg")){
tFile=new File(fileName+".jpeg");
}
ImageIO.write(ResultBuffer, "jpeg", tFile);
System.out.println("sukses");
}
catch(IOException x){ JOptionPane.showMessageDialog(null,
x.getMessage(),"error",JOptionPane.ERROR_MESSAGE);
}
}


    
}
