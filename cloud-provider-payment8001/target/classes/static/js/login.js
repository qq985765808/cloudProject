(function(a){var e=a("#bg").children("canvas"),c=e[0],o=e[1],p=e[2],g={circle:{amount:18,layer:3,color:[157,97,207],alpha:0.3},line:{amount:12,layer:3,color:[255,255,255],alpha:0.3},speed:0.5,angle:20};if(c.getContext){var d=c.getContext("2d"),m=o.getContext("2d"),n=p.getContext("2d"),r=window.Math,i=g.angle/360*r.PI*2,f=[],q=[],v,u,t;requestAnimationFrame=window.requestAnimationFrame||window.mozRequestAnimationFrame||window.webkitRequestAnimationFrame||window.msRequestAnimationFrame||window.oRequestAnimationFrame||function(w,x){setTimeout(w,1000/60)};cancelAnimationFrame=window.cancelAnimationFrame||window.mozCancelAnimationFrame||window.webkitCancelAnimationFrame||window.msCancelAnimationFrame||window.oCancelAnimationFrame||clearTimeout;var s=function(){v=a(window).width();u=a(window).height(),e.each(function(){this.width=v;this.height=u})};var k=function(C,D,B,z,w){var A=m.createRadialGradient(C,D,B,C,D,0);A.addColorStop(0,"rgba("+z[0]+","+z[1]+","+z[2]+","+w+")");A.addColorStop(1,"rgba("+z[0]+","+z[1]+","+z[2]+","+(w-0.1)+")");m.beginPath();m.arc(C,D,B,0,r.PI*2,true);m.fillStyle=A;m.fill()};var l=function(E,F,D,z,w){var A=E+r.sin(i)*D,B=F-r.cos(i)*D,C=n.createLinearGradient(E,F,A,B);C.addColorStop(0,"rgba("+z[0]+","+z[1]+","+z[2]+","+w+")");C.addColorStop(1,"rgba("+z[0]+","+z[1]+","+z[2]+","+(w-0.1)+")");n.beginPath();n.moveTo(E,F);n.lineTo(A,B);n.lineWidth=3;n.lineCap="round";n.strokeStyle=C;n.stroke()};var j=function(){d.clearRect(0,0,v,u);var w=[];w[0]=d.createRadialGradient(v*0.3,u*0.1,0,v*0.3,u*0.1,v*0.9);w[0].addColorStop(0,"rgb(0, 26, 77)");w[0].addColorStop(1,"transparent");d.translate(v,0);d.scale(-1,1);d.beginPath();d.fillStyle=w[0];d.fillRect(0,0,v,u);w[1]=d.createRadialGradient(v*0.1,u*0.1,0,v*0.3,u*0.1,v);w[1].addColorStop(0,"rgb(0, 150, 240)");w[1].addColorStop(0.8,"transparent");d.translate(v,0);d.scale(-1,1);d.beginPath();d.fillStyle=w[1];d.fillRect(0,0,v,u);w[2]=d.createRadialGradient(v*0.1,u*0.5,0,v*0.1,u*0.5,v*0.5);w[2].addColorStop(0,"rgb(40, 20, 105)");w[2].addColorStop(1,"transparent");d.beginPath();d.fillStyle=w[2];d.fillRect(0,0,v,u)};var b=function(){var E=r.sin(i),w=r.cos(i);if(g.circle.amount>0&&g.circle.layer>0){m.clearRect(0,0,v,u);for(var z=0,C=f.length;z<C;z++){var A=f[z],H=A.x,I=A.y,D=A.radius,F=A.speed;if(H>v+D){H=-D}else{if(H<-D){H=v+D}else{H+=E*F}}if(I>u+D){I=-D}else{if(I<-D){I=u+D}else{I-=w*F}}A.x=H;A.y=I;k(H,I,D,A.color,A.alpha)}}if(g.line.amount>0&&g.line.layer>0){n.clearRect(0,0,v,u);for(var B=0,C=q.length;B<C;B++){var A=q[B],H=A.x,I=A.y,G=A.width,F=A.speed;if(H>v+G*E){H=-G*E}else{if(H<-G*E){H=v+G*E}else{H+=E*F}}if(I>u+G*w){I=-G*w}else{if(I<-G*w){I=u+G*w}else{I-=w*F}}A.x=H;A.y=I;l(H,I,G,A.color,A.alpha)}}t=requestAnimationFrame(b)};var h=function(){f=[];q=[];if(g.circle.amount>0&&g.circle.layer>0){for(var w=0;w<g.circle.amount/g.circle.layer;w++){for(var x=0;x<g.circle.layer;x++){f.push({x:r.random()*v,y:r.random()*u,radius:r.random()*(20+x*5)+(20+x*5),color:g.circle.color,alpha:r.random()*0.2+(g.circle.alpha-x*0.1),speed:g.speed*(1+x*0.5)})}}}if(g.line.amount>0&&g.line.layer>0){for(var y=0;y<g.line.amount/g.line.layer;y++){for(var z=0;z<g.line.layer;z++){q.push({x:r.random()*v,y:r.random()*u,width:r.random()*(20+z*5)+(20+z*5),color:g.line.color,alpha:r.random()*0.2+(g.line.alpha-z*0.1),speed:g.speed*(1+z*0.5)})}}}cancelAnimationFrame(t);t=requestAnimationFrame(b);j()};a(document).ready(function(){s();h()});a(window).resize(function(){s();h()})}})(jQuery);