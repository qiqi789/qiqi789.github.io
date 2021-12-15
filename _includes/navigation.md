* [研究 Research](/research)
  * [研究资源 Research venues, resources](/research/venues.html)
* [教课 Teaching](/teaching)
  * [人工智能导论 (Introduction to Artificial Intelligence)](/teaching/AI)
  * [大数据技术（Big Data Analysis)](/teaching/big-data)
  * [网络安全技术](/teaching/network-security)

  * [以往课程 teaching archive](/teaching)
  
* 硕士研究生
  * 林小惟，梁哲敏，刘小龙，刘庆鑫
  
  * 林乾广(中国移动，2021)，李文权(佰锐科技AI算法工程师，2021)，王荣俊(中国移动，2020)


<ul>
<!--**新消息**: -->
  {% assign thisyear = 'now' | date: "%Y" %}
  {% assign sorted_posts = (site.posts | sort: 'date') %}
  {% for post in sorted_posts %}
  {% assign currentdate = post.date | date: "%Y" %}
  {% if currentdate >= thisyear %}
  <li>
    <a href="{{ post.url }}">{{post.title}}</a>
    {{ post.excerpt }}
  </li>
  {% endif %}
  {% endfor %}
</ul>

