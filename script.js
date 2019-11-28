document.write("課題1");
document.write("<br>");
for(var a=0; a<5; a++)
    {document.write("★");}
    {document.write("<br>");}
    {document.write("---------------");}

document.write("<p>");

document.write("課題2");
document.write("<br>");
for(var b=0; b<2; b++){for(var c=0; c<3; c++)
                        {document.write("★");}
                         document.write("<br>");}
                        {document.write("---------------");}

document.write("<p>");

document.write("課題3");
document.write("<br>");
for(var b=0; b<2; b++){for(var c=0; c<5; c++)
                        {document.write("☆");}
                         document.write("<br>");}
                        {document.write("---------------");}

document.write("<p>");

document.write("課題4");
document.write("<br>");
for(var b=0; b<4; b++){for(var c=0; c<4; c++)
                        {document.write("★");}
                         document.write("<br>");}
                        {document.write("---------------");}

document.write("<p>");

document.write("課題5");
document.write("<br>");
for(var b=0; b<4; b++){for(var c=0; c<3; c++)
                        {document.write("★");}
                         document.write("<br>");}
                        {document.write("---------------");}

document.write("<p>");

document.write("課題6");
document.write("<br>");
for(var b=0; b<3; b++){for(var c=0; c<3; c++)
                        {if(c%2==0)
                        {document.write("★");
                        }
                       else{document.write("☆");
                           }
                        }
                         document.write("<br>");}
                        {document.write("---------------");}

document.write("<p>");

document.write("課題7");
document.write("<br>");
for(var b=0; b<5; b++){for(var c=0; c<5; c++)
                        {if(c%2==0)
                        {document.write("★");
                        }
                         else{document.write("☆");
                             }
                        }
                        document.write("<br>");
                        }
                        {document.write("---------------");
                        }

document.write("<p>");

document.write("課題8");
document.write("<br>");
for(var stella1=0; stella1<5; stella1++){
    for(var stella2=0; stella2<=stella1; stella2++){
        document.write("★");}
    {document.write("<br>")}
}
{document.write("---------------")}

document.write("<p>");

function menseki(hankei,pai){
    return hankei*hankei*pai+"です。";
}

document.write("半径5cmの面積は"+menseki(5,3.14));
document.write("<br>");
document.write("半径7cmの面積は"+menseki(7,3.14));
document.write("<br>");
document.write("半径10cmの面積は"+menseki(10,3.14));

document.write("<p>");

function yuuenchi(otona,kodomo){
    return "グループの合計金額は"+(otona*500+kodomo*200)+"円です。";
}

document.write("A"+yuuenchi(2,4));
document.write("<br>");
document.write("B"+yuuenchi(1,5));
document.write("<br>");
document.write("C"+yuuenchi(3,7));